#!/bin/bash

REPOSITORY=/home/ec2-user/app/step2
PROJECT_NAME=Springboot_bookstore

echo "> Build 파일 복사"
cp $REPOSITORY/zip/*.jar $REPOSITORY/

echo "> 현재 구동 중인 애플리케이션 pid 확인"

# 현재 수행 중인 스프링 부트 애플리케이션의 프로세스 ID찾기
# 실행중이면 종료
CURRENT_PID=$(pgrep -fl Springboot_bookstore.*.jar)

echo "현재 구동 중인 애플리케이션 pid: $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then
  echo "> 현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다."
else
  echo "> kill -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> 새 애플리케이션 배포"

JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)

echo "> JAR name: $JAR_NAME"
echo "> $JAR_NAME에 실행권한 추가"
chmod +x $JAR_NAME

echo "> $JAR_NAME 실행"

nohup java -jar \
    -Dspring.config.location=classpath:/application.properties,classpath:/application-real.properties,/home/ec2-user/app/application-real-db.properties \
    -Dspring.profiles.active=real \
    $JAR_NAME > $REPOSITORY/nohup.out 2>&1 & 
    # nohup실행 시 CodeDeploy는 무한 대기