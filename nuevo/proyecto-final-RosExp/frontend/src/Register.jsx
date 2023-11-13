import {  useState } from "react";
import axios from "axios";

function Register() {
          
    const [dni, setDni] = useState("");
    const [apellidoPaterno, setApellidoPaterno] = useState("");
    const [apellidoMaterno, setApellidoMaterno] = useState("");
    const [nombrePila, setNombrePila] = useState("");
    const [image, setImage] = useState("");
    const [genero, setGenero] = useState("");
    const [fechaNacimiento, setFechaNacimiento] = useState("");
    const [edad, setEdad] = useState("");
    const [password, setPassword] = useState("");
    async function save(event) {
        event.preventDefault();
        try {
          await axios.post("http://127.0.0.1:8080/directorvuelo", {
            dni: dni,
            apellidoPaterno : apellidoPaterno,
            apellidoMaterno : apellidoMaterno,
            nombrePila : nombrePila,
            image : image,
            genero : genero,
            fechaNacimiento : fechaNacimiento,
            edad : edad,
            password : password,
          });
          alert("Employee Registation Successfully");

        } catch (err) {
          alert(err);
        }
      }
  
    return (
    <div>
    <div class="container mt-4" >
    <div class="card">
            <h1>Director de Vuelo Registation</h1>
    
    <form>
        <div class="form-group">
          <label>Director Vuelo name</label>
          <input type="text"  class="form-control" id="directorvuelo" placeholder="Enter Dni"
          
          value={dni}
          onChange={(event) => {
            setDni(event.target.value);
          }}
          />
        </div>


        <div class="form-group">
          <label>Apellido Paterno</label>
          <input type="apellidoPaterno"  class="form-control" id="apellidoPaterno" placeholder="Enter Apellido Paterno"
          
          value={apellidoPaterno}
          onChange={(event) => {
            setApellidoPaterno(event.target.value);
          }}
          
          />
 
        </div>

        <div class="form-group">
          <label>Apellido Materno</label>
          <input type="apellidoMaterno"  class="form-control" id="apellidoMaterno" placeholder="Enter Apellido Materno"
          
          value={apellidoMaterno}
          onChange={(event) => {
            setApellidoMaterno(event.target.value);
          }}
          />
        </div>

        <div class="form-group">
          <label>Nombre de Pila</label>
          <input type="nombrePila"  class="form-control" id="nombrePila" placeholder="Enter Nombre de Pila"
          
          value={nombrePila}
          onChange={(event) => {
            setNombrePila(event.target.value);
          }}
          />
        </div>

        <div class="form-group">
        <label>Image</label>
        <input type="imagen"  class="form-control" id="imagen" placeholder="Enter imagen"
        
        value={image}
        onChange={(event) => {
            setImage(event.target.value);
        }}
        />  
        </div>


        <div class="form-group">
        <label>Genero</label>
        <input type="genero"  class="form-control" id="genero" placeholder="Enter genero"

        value={genero}
        onChange={(event) => {
            setGenero(event.target.value);
        }}

        />


        </div>
      
        <div class="form-group">
        <label>Fecha Nacimiento</label>
        <input type="fechanacimiento"  class="form-control" id="fechanacimiento" placeholder="Enter Fecha Nacimiento"

        value={fechaNacimiento}
        onChange={(event) => {
            setFechaNacimiento(event.target.value);
        }}

        />
        
        </div>

        <div class="form-group">
            <label>edad</label>
            <input type="edad"  class="form-control" id="edad" placeholder="Enter Edad"
            
            value={edad}
            onChange={(event) => {
              setEdad(event.target.value);
            }}
            
            />
          </div>

        <button type="submit" class="btn btn-primary mt-4" onClick={save} >Save</button>
       
      </form>



    </div>
    </div>
     </div>
    );
  }
  
  export default Register;