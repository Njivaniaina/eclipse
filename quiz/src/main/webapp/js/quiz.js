let accueil = document.querySelector(".accueil");
let start = document.querySelector(".start");
let propos = document.querySelector(".content");

let accueil_button = document.querySelector("#accueil");
let start_button = document.querySelector("#start");
let propos_button = document.querySelector("#propos");
let propos_vers_button = document.querySelector("#propos_vers");

accueil_button.addEventListener('click', ()=>{
	accueil.style.display = 'flex';
	start.style.display = 'none';
	propos.style.display = 'none';
});

start_button.addEventListener('click', ()=>{
	accueil.style.display = 'none';
	start.style.display = 'flex';
	propos.style.display = 'none';
});

propos_button.addEventListener('click', ()=>{
	accueil.style.display = 'none';
	start.style.display = 'none';
	propos.style.display = 'flex';
});

propos_vers_button.addEventListener('click', ()=>{
	accueil.style.display = 'none';
	start.style.display = 'none';
	propos.style.display = 'flex';
});