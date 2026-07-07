import React from "react";
import SalonDetail from "./SalonDetail";
import Button from "@mui/material/Button";
import { Divider } from "@mui/material";
import SalonServiceDetails from "./SalonServiceDetails";
import Review from "../../Review/Review";
import CreateReviewForm from "../../Review/CreateReviewForm";

const tabs = [
  { name: "All Services" },
  { name: "Reviews" },
  { name: "create Review" },
];
const SalonDetails = () => {
  const [activeTab, setActiveTab] = React.useState(tabs[0]);
  const handleActiveTab = (tab) => ()=>setActiveTab(tab);
  return (
    <div className="px-5 bg-slate-50 lg:px-20">
      <SalonDetail />

      <div className="space-y-5">
        <div className="flex gap-2">
          {tabs.map((item) => (
            <Button
              onClick={handleActiveTab(item)}
              variant={item.name == activeTab.name ? "contained" : "outlined"}
            >
              {item.name}
            </Button>
          ))}
        </div>
        <Divider />
        <div>
           {activeTab.name == "create Review" ? <div className="flex justify-center">
            <CreateReviewForm/>

           </div>: activeTab.name == "Reviews" ? <div>
             <Review/>
           </div> : <div>
            <SalonServiceDetails/>
           </div> }
        </div>
        
      </div>
    </div>
  );
};

export default SalonDetails;
