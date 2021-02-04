gcloud iam service-accounts create cloud-run-acc \
    --description="Cloud run service account" \
    --display-name="cloud-run-acc"
gcloud projects add-iam-policy-binding otto-university-302315 \
  --member="serviceAccount:cloud-run-acc@otto-university-302315.iam.gserviceaccount.com" \
  --role="roles/run.invoker"
gcloud run deploy user-app --image eu.gcr.io/otto-university-302315/demorun3:7 \
  --platform managed \
  --service-account cloud-run-acc@otto-university-302315.iam.gserviceaccount.com \
  --vpc-connector vpcconnector1 \
  --add-cloudsql-instances second \
  --region europe-west3 \
  --allow-unauthenticated
