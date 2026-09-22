import type { CapacitorConfig } from '@capacitor/cli';

const config: CapacitorConfig = {
  appId: 'org.scarletreverie.redbound',
  appName: 'Redbound',
  webDir: 'mobile-dist',
  android: {
    backgroundColor: '#07070a',
    allowMixedContent: false,
  },
  ios: {
    backgroundColor: '#07070a',
  },
  server: {
    androidScheme: 'https',
    iosScheme: 'https',
  },
};

export default config;
