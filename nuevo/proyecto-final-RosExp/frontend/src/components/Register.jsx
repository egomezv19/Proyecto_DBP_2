import {  useState } from "react";
import axios from "axios";

function Register() {
  
    const [dni, setDni] = useState("");
    const [apellidoPaterno, setApellidoPaterno] = useState("");
    const [apellidoMaterno, setApellidoMaterno] = useState("");
    const [nombrePila, setNombrePila] = useState("");
    const [image, setImage] = useState("");
    const [genero, setGenero] = useSate("");
    const [fechaNacimiento, setFechaNacimiento] = useState("");
    const [edad, setEdad] = useState("");
    const [password, setPassword] = useState("");


    async function save(event) {
        event.preventDefault();
        try {
          await axios.post("http://localhost:8085/api/v1/employee/save", {
          employeename: employeename,
          email: email,
          password: password,
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
        

        

        <button type="submit" class="btn btn-primary mt-4" onClick={save} >Save</button>
       
      </form>
    </div>
    </div>
     </div>
    );
  }
  
  export default Register;