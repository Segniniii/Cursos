
package com.pagina.service;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {
 public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    // El BucketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "techshop-1fdae.appspot.com";

    // Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "techshop";

    // Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    // El nombre del archivo Json
    final String archivoJsonFile = "techshop-1fdae-firebase-adminsdk-cxmxj-1683f11266.json";    
}
