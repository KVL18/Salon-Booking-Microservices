import React from "react";

const salonDetail = () => {
  return (
    <div className="space-y-5 mb-20">
      <section className="grid grid-cols-2 gap-3">
        <div className="col-span-2 ">
          <img
            className="w-full rounded-md h-[15rem] object-cover"
            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0PjscFOCzR700HF0rZJvbrnXX76JyCbCxW4csrq52Rw&s=10"
          />
        </div>
        <div className="col-span-1">
          <img
            className="w-full rounded-md h-[15rem] object-cover"
            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPAmdvmNxy2Ka7raJMAUlW7wDmyhMv7kX5u5Q3FMFu6Q&s=10"
          />
        </div>
        <div className="col-span-1 ">
          <img
            className="w-full rounded-md h-[15rem] object-cover"
            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTbisWAEp4pbzVFKjZqZxjFBB4ngBv1LXzHIagakVwlag&s=10"
          />
        </div>
      </section>
      <section className="space-y-3">
        <h1 className="text-3xl font-bold "> Beauty Salon</h1>
        <p>Church Street ,Banglore</p>
        <p><strong>
          Timing:
        </strong> 10:00 AM - 8:00 PM</p>
      </section>
    </div>
  );
};

export default salonDetail;
