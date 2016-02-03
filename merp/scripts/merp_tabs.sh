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
  ttab -t auth gradle run -x test -p $DEV_HOME/intapi-auth
##XMLRPC  
  ttab -t dispatcher gradle run -x test -p $DEV_HOME/extapi-xmlrpc-dispatcher
  ttab -t translator gradle run -x test -p $DEV_HOME/intapi-xmlrpc-translator
  ttab -t ticket-management gradle run -x test -p $DEV_HOME/intapi-ticket-management
  ttab -t buyer-integration gradle run -x test -p $DEV_HOME/extapi-buyer-integration
## Company
  ttab -t company gradle run -x test -p $DEV_HOME/intapi-company
## Invoice
  ttab -t invoice gradle run -x test -p $DEV_HOME/intapi-invoice
  ttab -t invoice-prochain-invoice-creation gradle run -x test -p $DEV_HOME/intapi-invoice/prochains/external-invoice-creation
  ttab -t inovice-prochain-invoice-finance-update gradle run -x test -p $DEV_HOME/intapi-invoice/prochains/external-invoice-finance-update
## EarlyPayment  
  ttab -t EP gradle run -x test -p $DEV_HOME/intapi-early-payment
  ttab -t EP-prochain-erp-reply-processing gradle run -x test -p $DEV_HOME/intapi-early-payment/prochains/erp-reply-processing
## SIM  
  ttab -t SIM gradle server:run -x test -p $DEV_HOME/intapi-supplier-information-management
  ttab -t SIM-prochain gradle supplier-details-processing:run -x test -p $DEV_HOME/intapi-supplier-information-management/prochains
fi




