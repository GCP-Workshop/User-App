gcloud --project=otto-university-302315 beta sql instances create initdb --region=europe-west3 --network=test-vpc --no-assign-ip
gcloud sql databases create users --instance=initdb
export DB_IP=$(gcloud sql instances describe initdb --project otto-university-302315 --format 'value(ipAddresses.ipAddress)')

gcloud run deploy user-app --image eu.gcr.io/otto-university-302315/demorun3:2 \
  --platform managed \
  --service-account cloud-run-acc@otto-university-302315.iam.gserviceaccount.com \
  --vpc-connector vpcconnector1 \
  --add-cloudsql-instances otto-university-302315:europe-west3:initdb \
  --update-env-vars POSTGRES_HOST=10.179.50.3,POSTGRES_USERNAME=postgres,POSTGRES_PASS=test@123 \
  --region europe-west3 \
  --allow-unauthenticated
