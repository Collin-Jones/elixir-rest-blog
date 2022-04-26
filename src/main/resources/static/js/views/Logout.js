import createView from "../createView.js";

export function Logout(){
    localStorage.clear();
    createView("/")
}