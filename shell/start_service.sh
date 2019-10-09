echo '---------start begin------'

DIR=/home/hgang
cd $DIR

ps -ef | grep erp-service-manage.jar | grep -v grep | awk '{print $2}' | xargs kill -9

sleep 3

nohup java -Dspring.profiles.active=dev -jar erp-service-manage.jar >/dev/null &

echo '---------start end------'
