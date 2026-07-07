import React from "react";
import CategoryCard from "./CategoryCard";
import ServiceCard from "./ServiceCard";
import { Button, Divider } from "@mui/material";
import RemoveShoppingCartIcon from "@mui/icons-material/RemoveShoppingCart";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import SelectedServiceList from "./SelectedServiceList";

const SalonServiceDetails = () => {
  const [selectedCategory, setSelectedCategory] = React.useState(0);

  const handleCategoryClick = (category) => () => {
    setSelectedCategory(category);
  };

  return (
    <div className="lg:flex gap-5 h-[90vh] mt-10">
      <section className="space-y-5 ,border-r lg:w-[25%] pr-5">
        {[1, 1, 1, 1.1].map((item, index) => (
          <CategoryCard
            key={index}
            selectedCategory={selectedCategory}
            item={index}
            handleCategoryClick={handleCategoryClick(index)}
          />
        ))}
      </section>

      <section className="lg:w-[50%] space-y-2 px-5 lg:px-20 overflow-y-auto">
        {[1, 1, 1, 1, 1, 1].map((item) => (
          <div className="space-y-4">
            <Divider />
            <ServiceCard />
          </div>
        ))}
      </section>
      <section className="lg:w-[25%] ">
        <div className="border rounded-md p-5">
          {true ?
            <div>
              <div className="flex items-center gap-2 ">
                <ShoppingCartIcon sx={{ fontSize: "30px", color: "green" }} />
                <h1 className="text-sm font-thin">Cart</h1>
              </div>
              <SelectedServiceList />
              <Button sx={{py:".7rem"}} fullWidth variant="contained">
                Book Now
              </Button>
            </div>
         : 
          <div className="flex flex-col gap-3 items-center justify-center">
            <RemoveShoppingCartIcon sx={{ fontSize: "30px", color: "green" }} />
            <h1>Not Selected</h1>
          </div> }
        </div>
      </section>
    </div>
  );
};

export default SalonServiceDetails;
