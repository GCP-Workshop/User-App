gcloud --project=otto-university-302315 beta sql instances create thirddb  --database-version=POSTGRES_12 --cpu=2 --memory=10GB  --region=europe-west3 --network=test-vpc --no-assign-ip
gcloud sql databases create users --instance=thirddb
export DB_IP=$(gcloud sql instances describe thirddb --project otto-university-302315 --format 'value(ipAddresses.ipAddress)')
gcloud sql users set-password postgres --instance=thirddb --prompt-for-password
gcloud run deploy user-app --image eu.gcr.io/otto-university-302315/demorun3:9 \
  --platform managed \
  --service-account cloud-run-acc@otto-university-302315.iam.gserviceaccount.com \
  --vpc-connector vpcconnector1 \
  --add-cloudsql-instances otto-university-302315:europe-west3:thirddb \
  --region europe-west3 \
  --allow-unauthenticated
  --no-traffic
gcloud run services update-traffic user-app --to-revisions LATEST=10
