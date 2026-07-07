import React from "react";

const CategoryCard = ({ handleCategoryClick, selectedCategory, item }) => {
  return (
    <div
      onClick={handleCategoryClick}
      className={`px-3 py-2 cursor-pointer flex gap-2 items-center ${
        selectedCategory === item
          ? "bg-green-500 text-white rounded-md"
          : ""
      }`}
    >
      <img
        className="w-14 h-14 object-cover rounded-full"
        src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcUc3kesL9LUoMcoYEv45FMvYAhyObsw3MiS9sBVyTgA&s=10"
        alt={item?.name}
      />

      <h1>vdfbdgdfghfghgfhf</h1>
    </div>
  );
};

export default CategoryCard;