// frontend/client/runtime-env.js
(function() {
  console.log('Loading runtime-env.js');
  window.__ENV__ = {
    BACKEND_API_BASE_URL: "http://localhost:8080"
  };
  console.log('Environment Variables:', window.__ENV__);
})();