package com.danielpm1982.REST_WS7_Client.helper;

public interface Helper {
	public abstract void upload(String uploadURL, String... fileToUploadPathString);
	public abstract void download(String downloadURL, String destineLocalFolder, String... fileNameArray);
}

/*
This is a helper class that encapsulates the manipulation of WebClient and related CXF and JAX-RS 
objects and methods. And can be called from anywhere inside this application (from console or Controller
classes, for instance).
These are local methods at the Consumer server, and their declaration (names) are not dependent on the
Provider interface method names or signatures (only for practical reasons the names are the same, but the
parameters are different).
For uploading files to the Provider server using this Consumer upload helper method, just pass the 
uploadURL (endPoint) and a list of local file paths to have the correspondent file data uploaded as Attachments.
For downloading and saving locally any Provider existing files using this Consumer download helper method,
just pass the downloadURL (endPoint), the destineLocalFolder where the downloaded files will be saved at the
Consumer side and an array with the existing files at the Provider side that the Consumer server wants to
download.
All logic is encapsulated inside the helper class.
See the helper class comments for more.
*/
