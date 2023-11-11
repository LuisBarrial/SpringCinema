var j=0;
var i =1;
var Json;
var cantidadboletos=j
var array = Array(i); //array para la modificacion de los botones
var obj=[] //Declaramos un array de objetos para posteriormente convertirlo en json
let valor; //valor de validacion del boton
let nohallado //validador para identificar valores repetidos
var l = this.j;
 
$(document).ready(function(){ //funcion cuando se activa el documento
ObtenerUsuarios()


  let aviso = $(".divtexto") //ayer dios y yo sabiamos para que servia, ahora solo lo sabe Dios
  $(".imagencirculo").click(function(){ //funcion de click de la imagen circulo
  console.log("Se dio en el valor: "+$(this).text()) //log para ver los valores que se dan
   
  this.classList.replace("imagencirculo","imagencirculoe1"); //cambiamos el estilo de boton para que cambie de color
  array.push($(this).text()); //al array se le agrega el nombre del texto del boton

  const progreso= document.getElementById('progreso');
const siguiente= document.getElementById("siguiente");
const anterior= document.getElementById("anterior");
const circle= document.querySelectorAll('.circle');
const divtexto= document.querySelectorAll('.divtexto');
let currentActive = 1;



siguiente.addEventListener('click', ()=>{
 currentActive++;
  if(currentActive > circle.length){
    currentActive = circle.length;
  }

  update();

}

)
anterior.addEventListener('click', ()=>{
  currentActive--;
   if(currentActive < 1){
     currentActive = 1;
   }
 
   update();
 
 }
 
 )

function update(){
  circle.forEach((circulo,index)=>{

    if(index<currentActive){
      circulo.classList.add('active');
    } else{
      circulo.classList.remove('active');
    }

  });
  const actives= document.querySelectorAll('.active');
  progreso.style.width = ((actives.length-1) / (circle.length-1))*100 + '%';

  if(currentActive===1){
    anterior.disabled = true;

  } else if(currentActive===circle.length){
    siguiente.disabled=true;
  }else{
    anterior.disabled=false;
    siguiente.disabled=false
  }
}
  


  console.log(array); //imprimimos el array para verlo
  i++; //aumentamos el iterador
  Array.prototype.countCertainElements = function(value){ //creamos una funcion donde evalua la cantidad de elementos denominados "value"
    return this.filter(arrayElement => arrayElement == value).length
  }
  var agregarvalor = { "nombre":$(this).text(), "estado": true}; //creamos un array de objetos en base al boton con default true

  if(array.countCertainElements($(this).text())%2==0 ){  //con la ffuncion anterior identificamos si aparecen 2 elementos repetidos

    for(let j=0;j<array.length;j++){ //bucle que recorre el array y elimimna el ultimo valor repetido
      var myIndex = array.indexOf($(this).text());
      if (myIndex !== -1) {
        array.splice(myIndex, 1); //funcion eliminar
        
      }

    }
    
    valor=1; //valor deseleccion

    this.classList.replace("imagencirculoe1","imagencirculo"); //reemplazo el estilo a deseleccionado
  }else{ 
    valor=2; //valor seleccion

    this.classList.replace("imagencirculo","imagencirculoe1"); //reemplado extilo a seleccionado

 
}
if(obj.length<1){
obj.push(agregarvalor);}


for(let i=0; i<obj.length; i++){
  if(obj[i].nombre==$(this).text()){ //si encuentra el valor repetido

    console.log("Encontrado"); //lo encontró
    if(valor==1){ 
      obj[i].estado=false;
    obj.splice(i,1);
    } //valor deseleccionado
    if(valor==2){
      obj[i].estado=true;} //valor s  eleccionado
      nohallado=0;
  }
  else{
    console.log("No he Encontrado nada"); //si no encuentra nada
    nohallado = 1 //validacion con valor 1
    
  }

}


if(obj.length==localStorage.cantidad){
  alert("No olvides que no puedes elegir mas de la cantidad acordada!");
  localStorage.data = JSON.stringify(obj);
  var miasi = JSON.parse(localStorage.data);
  if(localStorage.cantidad==1){
document.getElementById("imagenSeleccionada").innerHTML=miasi[0].nombre.trim();
  }
  return;
}



if(nohallado==1 && valor==2){ //si no encontro nada y el valor de ahora es seleccionado
obj.push(agregarvalor);} //enotnces se pushea el nuevo objeto con default true {true significa seleccionado}
nohallado=0;//se reinicia el validador

var acum="";






for(let i=0;i<obj.length;i++)
{

  if(obj[i].estado==true){
    acum=acum+obj[i].nombre;
    document.getElementById("imagenSeleccionada").innerHTML=acum;
}}




if(obj.length==0){
  document.getElementById("imagenSeleccionada").innerHTML="";
}



console.log(obj);


Json = "asientos"+JSON.stringify(obj); //creo un string con formato JSON con nombre padre "asientos"
console.log(Json);

})
})
console.log("Se dio en el valor: "+$(this).text())


document.getElementById("cantidadj").textContent=" "+j;
document.getElementById("cantidadentradas").textContent=" "+j;
var botonsuma=document.getElementsByClassName("button-entries1");
function clicked(){

  this.j++;
  document.getElementById("cantidadentradas").textContent=j;
  document.getElementById("cantidadj").textContent=j;
            cantidadboletos=this.j;
        let precio=cantidadboletos*15;
        var txtprecio=precio.toString();
        localStorage.precio=precio;

        localStorage.cantidad=cantidadboletos;

}
function clicked2(){

 this.j--;
  if(j<0){
    j=0;
  }
    cantidadboletos=this.j;
        let precio=cantidadboletos*15;
        localStorage.precio=precio;
        localStorage.cantidad=cantidadboletos;
  document.getElementById("cantidadentradas").textContent=j;
  document.getElementById("cantidadj").textContent=j;
}
const coupon = document.getElementById("coupon-button");
const coupontxt = document.getElementById("coupon");
const txtcoupon = document.getElementById("text-coupon");

function buttonclicked(){
  const cuponactivo="PRIMERACOMPRA2022"
  if(document.getElementById("coupon").value==cuponactivo){
    document.getElementById("text-coupon").textContent="se aplicara un descuento de 20%";
    console.log("nono")
  }
  else{ document.getElementById("text-coupon").textContent="eRROR";
  console.log("sisi")}

}



function GuardarAsientos(){

localStorage.data = JSON.stringify(obj);

}

async function ObtenerUsuarios(){

    const request = await fetch('api/asientos', {
    method: 'GET',
    headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
    }
    });
    const asientos = await request.json();

    for(let asiento of asientos){


        let idAsientos = "#" + asiento.asiento;

;
        document.querySelector(idAsientos).classList.replace("imagencirculo","imagencirculonodisponible");




    }
}