gcloud compute networks vpc-access connectors create vpcconnector1 \
--network test-vpc \
--region europe-west3 \
--range 192.168.1.0/28

gcloud compute networks vpc-access connectors delete vpcconnector1 --region europe-west3
