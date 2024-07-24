# Stage 1: Build the React app
FROM node:18 AS build

# Set working directory
WORKDIR /app/client

# Copy package.json and package-lock.json
COPY client/package*.json ./

# Install dependencies
RUN npm install

# Copy source files
COPY client/ ./

ARG BACKEND_API_BASE_URL
ENV BACKEND_API_BASE_URL=$BACKEND_API_BASE_URL

# Build the React app using Parcel
RUN npm run build

# Stage 2: Serve the app with Nginx
FROM nginx:alpine

# Copy the dist files to the Nginx html directory
COPY --from=build /app/client/dist /usr/share/nginx/html

# Copy the runtime-env.js to the Nginx html directory
COPY client/runtime-env.js /usr/share/nginx/html/runtime-env.js

# Copy the Nginx configuration file
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Copy the entrypoint script
COPY entrypoint.sh /entrypoint.sh

# Make the entrypoint script executable
RUN chmod +x /entrypoint.sh

# Environment variables
ARG BACKEND_API_BASE_URL
ENV BACKEND_API_BASE_URL $BACKEND_API_BASE_URL

# Set entrypoint
ENTRYPOINT ["/entrypoint.sh"]
CMD ["nginx", "-g", "daemon off;"]
