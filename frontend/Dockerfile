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

# Build the React app using Parcel
RUN npm run build

# Stage 2: Serve the app with Nginx
FROM nginx:alpine

# Copy the dist files to the Nginx html directory
COPY --from=build /app/client/dist /usr/share/nginx/html

# Copy the Nginx configuration file
COPY nginx.conf /etc/nginx/conf.d/default.conf
