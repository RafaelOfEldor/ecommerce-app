#!/bin/sh

if [ -z "${BACKEND_API_BASE_URL}" ]; then
  echo "Error: BACKEND_API_BASE_URL environment variable is not set."
  exit 1
fi

sed -i "s|__BACKEND_API_BASE_URL__|${BACKEND_API_BASE_URL}|g" /usr/share/nginx/html/runtime-env.js

sed -i "s|__BACKEND_API_BASE_URL__|${BACKEND_API_BASE_URL}|g" /etc/nginx/conf.d/default.conf

nginx -g 'daemon off;'