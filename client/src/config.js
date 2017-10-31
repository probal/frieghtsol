export const API_ROOT = (process.env.NODE_ENV === 'production') ?
    'https://localhost:8000/' :
    'http://localhost:8000/'

export const CookieDomain = (process.env.NODE_ENV === 'production') ?
    '.freightsol.com' :
    ''