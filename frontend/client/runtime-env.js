// frontend/client/runtime-env.js
(function() {
  console.log('Loading runtime-env.js');
  window.__ENV__ = {
    BACKEND_API_BASE_URL: "__BACKEND_API_BASE_URL__"
  };
  console.log('Environment Variables:', window.__ENV__);
})();
