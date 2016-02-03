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







DEV_HOME=/Users/ericanderson/Development/Taulia


if [ $# -eq 0 ] || [ $1 == 'start' ]; then 
  #screen -dmS activemq bash -c '/opt/apache-activemq-5.11.2/bin/activemq start
  ttab -t intapi-auth gradle run -x test -p $DEV_HOME/intapi-auth
##XMLRPC  
  ttab -t extapi-xmlrpc-dispatcher gradle run -x test -p $DEV_HOME/extapi-xmlrpc-dispatcher
  ttab -t intapi-translator gradle run -x test -p $DEV_HOME/intapi-xmlrpc-translator
  ttab -t intapi-ticket-management gradle run -x test -p $DEV_HOME/intapi-ticket-management
  ttab -t extapi-buyer-integration gradle run -x test -p $DEV_HOME/extapi-buyer-integration
## Company
  ttab -t intapi-company gradle run -x test -p $DEV_HOME/intapi-company
## Invoice
  ttab -t intapi-invoice gradle run -x test -p $DEV_HOME/intapi-invoice
  ttab -t intapi-invoice-prochain-invoice-creation gradle run -x test -p $DEV_HOME/intapi-invoice/prochains/external-invoice-creation
  ttab -t intapi-inovice-prochain-invoice-finance-update gradle run -x test -p $DEV_HOME/intapi-invoice/prochains/external-invoice-finance-update
## EarlyPayment  
  ttab -t intapi-early-payment gradle run -x test -p $DEV_HOME/intapi-early-payment
  ttab -t intapi-early-payment-prochain-erp-reply-processing gradle run -x test -p $DEV_HOME/intapi-early-payment/prochains/erp-reply-processing
## SIM  
  ttab -t intapi-supplier-information-management gradle server:run -x test -p $DEV_HOME/intapi-supplier-information-management
  ttab -t intapi-supplier-information-management gradle supplier-details-processing:run -x test -p $DEV_HOME/intapi-supplier-information-management/prochains
fi




