#!/bin/bash

# This is a maven based webapp project deploy script must
# must be put under the root directory of the project.
# For example, my-app is your project name, then the 
# deploy script path will be my-app/deploy.sh.

# Remember to change the tomcat home path.
tomcat_home=${HOME}/tomcat/apache-tomcat-10.0.23 
project_path=$(dirname `realpath "$0"`)
project_name=${project_path##*/}

load() {
  echo "---> Copy war"
  cp -v ${project_path}/target/${project_name}.war ${tomcat_home}/webapps 
  echo "---> Start tomcat"
  startup.sh
}

unload() {
  echo "---> Shutdown tomcat"
  shutdown.sh
  echo "---> Do cleanning"
  rm -rvf ${tomcat_home}/webapps/{${project_name},${project_name}.war} \
          ${tomcat_home}/work/Catalina/localhost/${project_name}
}

reload() {
  unload
  load
}

if [[ "$1" == "load" || "$1" == "l" ]]; then
  load
elif [[ "$1" == "unload" || "$1" == "u" ]]; then
  unload
elif [[ "$1" == "reload" || "$1" == "r" ]]; then
  reload
else
  echo "You must feed an argument, load, reload or unload. :)"
fi
