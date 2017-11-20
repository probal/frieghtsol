export const CookieDomain = (process.env.NODE_ENV === 'production') ? 'localhost:8000' : ''
export const API_ROOT = ((process.env.NODE_ENV === 'production') ? 'http://localhost:8000/' : 'http://localhost:8000/') + 'api/v1/'

