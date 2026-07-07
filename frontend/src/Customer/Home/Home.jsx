import React from "react";
import Banner from "./Banner";
import HomeServiceCard from "./HomeServiceCard";
import { services } from "../../Data/service";
import SalonList from "../Salon/SalonList";

const Home = () => {
  return (
    <div className="space-y-20">
      <section>
        <Banner />
      </section>

      <section className="space-y-10 lg:space-y-0 flex item-centre gap-5 px-20">
        <div className="w-full lg:w-1/2">
          <h1 className="text-2xl font-semibold pb-9">
            What are you looking for, Bestie? 👀
          </h1>
          <div className="flex flex-wrap justify-center items-center gap-5">
            {services.map((item) => (
              <HomeServiceCard key={item.id} item={item} />
            ))}
          </div>
        </div>
        <div
          className="w-full lg:w-1/2 border grid gap-3 grid-cols-2 grid-rows-12 h-[45vh]
         md:h-[90vh]"
        >
          <div className="row-span-7">
            <img
              className="h-full w-full rounded-md"
              src="https://encrypted-tbn0.gstatic.com/
            images?q=tbn:ANd9GcSHKHV6bkIY1w9_NlYkjBwGXTQriAsJweY97p0Krs9FHQ&s=10"
            />
          </div>
          <div className="row-span-5">
            <img
              className="h-full w-full rounded-md"
              src="https://encrypted-tbn0.gstatic.com/
            images?q=tbn:ANd9GcSLCvdFr_k4W_xvxyWTJSqTGevGwKxQWa-wxAaeExewig&s=10"
            />
          </div>
          <div className="row-span-7">
            <img
              className="h-full w-full rounded-md"
              src="https://encrypted-tbn0.gstatic.com/
            images?q=tbn:ANd9GcTbOBEguM4cYYjXxOBek9hAKQ2gOo96Y8rcKLpFoVdrfw&s=10"
            />
          </div>
          <div className="row-span-5">
            <img
              className="h-full w-full rounded-md"
              src="https://encrypted-tbn0.gstatic.com/
            images?q=tbn:ANd9GcRi8pat0V54agATsI0UwAbLcPwR25Igff65VgUEPvWOGg&s=10"
            />
          </div>
        </div>
      </section>
      <section className="px-20">
      <h1 className="text-3xl font-bold pb-10"> Book Your Favourite Salon</h1>
         <SalonList />
      </section>
    </div>
  );
};

export default Home;
