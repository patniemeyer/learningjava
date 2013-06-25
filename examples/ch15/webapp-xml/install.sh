/pkg/jakarta-tomcat-4.0/bin/shutdown.sh
cp learningjava.war /pkg/jakarta-tomcat-4.0/webapps
rm -rf /pkg/jakarta-tomcat-4.0/webapps/learningjava
/pkg/jakarta-tomcat-4.0/bin/startup.sh
