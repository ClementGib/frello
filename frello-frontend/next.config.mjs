{import('next').NextConfig}
const nextConfig = {
  async redirects() {
    return [
      {
        source: "/",
        destination: "/login/login",
        permanent: true,
      },
    ];
  },
};

export default nextConfig;