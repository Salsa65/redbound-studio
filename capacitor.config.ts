import type { CapacitorConfig } from '@capacitor/cli';

const config: CapacitorConfig = {
  appId: 'org.scarletreverie.redbound',
  appName: 'Redbound',
  webDir: 'mobile-dist',
  android: {
    backgroundColor: '#07070a',
    allowMixedContent: false,
  },
  server: {
    androidScheme: 'https',
  },
};

export default config;
