import React from "react";
import HomeVideo from "../../assets/HomeVideo.mp4";

const Banner = () => {
  return (
    <div className="w-full relative h-[80vh] overflow-hidden">
      <video
        className="w-full h-full object-cover"
        src={HomeVideo}
        autoPlay
        muted
        loop
        playsInline
      />
        <div className="textPart absolute flex flex-col items-center justify-center inset-0
        text-white  space-y-3 px-5 bg-black/40 z-0">
        <h1 className="text-5xl font-bold">Be your self</h1>
        <p className="text-slate-400 text-2xl text-centre font-semibold">
        Discover and Book Beauty, wellness near you
        </p>
        <input
          type="text"
          placeholder="Search for services, salons, spas..."
          className=" max-w-md px-4 py-2 rounded-full text-black focus:outline-none focus:ring-2 focus:ring-blue-500
          w-[15rem] md:w-[33rem]"
        />
        </div>
    </div>
  );
};

export default Banner;