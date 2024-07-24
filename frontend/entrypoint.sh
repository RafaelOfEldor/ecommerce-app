#!/bin/sh

echo "Replacing environment variables in runtime-env.js"
sed -i 's|%%REACT_APP_API_URL%%|'${REACT_APP_API_URL}'|g' /usr/share/nginx/html/runtime-env.js

exec "$@"
