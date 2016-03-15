


#Alaises
alias tun='ssh -C -D 19999 -L 22222:macmini:22 -L 15900:macmini:5900 -L 13389:192.168.3.124:3389 root@nosredna.no-ip.org'
alias tunip='ssh -C -D 19999 -L 22222:macmini:22 -L 15900:macmini:5900 -L 13389:192.168.3.124:3389 root@67.161.219.65'
alias tunmac='ssh -C -D 19999 -L 15900:macmini:5900 -L 25900:dmac:5900 root@nosredna.no-ip.org'
alias qe-tc='ssh ec2-user@qetest-ted.taulia.com'
alias mci='mvn clean install'
alias csdev='ssh clubsuede:cscs@csdev'


#Dev Alaises
alias g='gradle clean check'
alias gskip='gradle clean build -x test'
alias grun='gradle -x test -x integrationTest run'
alias gitadd='git add --all'


alias ..='cd ..'

export GRADLE_HOME=/Users/eanderson/.gvm/gradle/current
export GROOVY_HOME=/Users/eanderson/.gvm/groovy/current



alias startdb='postgres -D /usr/local/var/postgres'
# pg_ctl -D /usr/local/var/postgres -l logfile start



## JAVA ##
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home
#export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0_60.jdk/Contents/Home
export JAVA_OPTS="$JAVA_OPTS -XX:MaxPermSize=512m -Xmx1536M -server -Dorg.terracotta.quartz.skipUpdateCheck=true -Djava.net.preferIPv4Stack=true"


## SCALA ##
export SCALA_HOME=/opt/scala-2.11.7


export MAVEN_HOME=/opt/maven

export PATH=/usr/local/bin:$JAVA_HOME/bin:$MAVEN_HOME/bin:$SCALA_HOME/bin:$PATH


### Added by the Heroku Toolbelt
export PATH="/usr/local/heroku/bin:$PATH"


alias usejdk8='export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home'
alias usejdk7='export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0_60.jdk/Contents/Home'


alias turnoffjmaf='ls /Library/LaunchDaemons/com.jamfsoftware.* | xargs sudo launchctl unload'
alias turnonjmaf='ls /Library/LaunchDaemons/com.jamfsoftware.* | xargs sudo launchctl load'


export TAULIAFUNCTIONALTESTER_CONFIG_LOCATION="/Users/ericanderson/.grails/tauliaPlatformConfig/tauliaFunctionalTester.conf"




#THIS MUST BE AT THE END OF THE FILE FOR SDKMAN TO WORK!!!
export SDKMAN_DIR="/Users/ericanderson/.sdkman"
[[ -s "/Users/ericanderson/.sdkman/bin/sdkman-init.sh" ]] && source "/Users/ericanderson/.sdkman/bin/sdkman-init.sh"
