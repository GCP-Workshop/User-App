gcloud run deploy user-app --image eu.gcr.io/otto-university-302315/demorun:2 \
  --platform managed \
  --service-account cloud-run-acc@otto-university-302315.iam.gserviceaccount.com \
  --image eu.gcr.io/otto-university-302315/demorun:3 \
  --update-env-vars POSTGRES_HOST=localhost,POSTGRES_USERNAME=postgres,POSTGRES_PASS=admin
  --region europe-west3 \
  --allow-unauthenticated