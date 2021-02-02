gcloud services enable secretmanager.googleapis.com

echo -n "172.168.0.1" | gcloud secrets create postgres-ip --locations=europe-west3 --replication-policy=user-managed --data-file=-
echo -n "username" | gcloud secrets create postgres-username --locations=europe-west3 --replication-policy=user-managed --data-file=-
echo -n "password" | gcloud secrets create postgres-password --locations=europe-west3 --replication-policy=user-managed --data-file=-
#update secret
echo -n "varname" | gcloud secrets versions add postgres-ip --data-file=-