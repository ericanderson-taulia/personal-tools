#!/bin/bash


#################     README    #######################
#
# Requirments
# 1. Install NPM   curl -L https://npmjs.org/install.sh | sh
# 2. Install ttabs    npm install -g ttab
# 3. Adjust DEV_HOME in script below
#
#
#  Created by Eric Anderson
#
#########################################################





DEV_HOME=/Users/eanderson/Development/taulia

#screen -dmS activemq bash -c '/opt/apache-activemq-5.11.2/bin/activemq start


echo "Using HOME:$DEV_HOME"

if [ $# -eq 0 ] || [ $1 == 'start' ]; then


## Auth
  ttab -t auth gradle run -x test -p $DEV_HOME/intapi-auth
## Company
  ttab -t company gradle run -x test -p $DEV_HOME/intapi-company
## Invoice
#  ttab -t invoice gradle run -x test -p $DEV_HOME/intapi-invoice
#  ttab -t invoice-prochain-invoice-creation gradle run -x test -p $DEV_HOME/intapi-invoice/prochains/external-invoice-creation
#  ttab -t inovice-prochain-invoice-finance-update gradle run -x test -p $DEV_HOME/intapi-invoice/prochains/external-invoice-finance-update
## EarlyPayment
  ttab -t EP gradle run -x test -p $DEV_HOME/intapi-early-payment
#  ttab -t EP-prochain-erp-reply-processing gradle run -x test -p $DEV_HOME/intapi-early-payment/prochains/erp-reply-processing
##
  ttab -t Monolith 'usejdk7; cd "/Users/eanderson/Development/taulia/monolith"; gradle run'
fi



## Close Tabs
## osascript -e 'tell application "Terminal" to close (every window whose name contains ".command")' & exit
