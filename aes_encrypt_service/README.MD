## How to use service

1. Prepare document for encrypting
    * PDF to BASE 64 : https://base64.guru/converter/encode/pdf


2. crete POST request to http://localhost:8083/rest/v1/aes with JSON body:
   <br>
   <code>
   { <br>
   "stringToEncrypt":"BASE64_text",  
   "secret":"MY_SECRET"  
   }
   </code>

3. Encrypted documents will be in HTTP response
4. Use ui-service

### Additional info:

* Adobe Acrobat Pro: PDF Forms: Inserting an Automatic Date Field
  https://www.uwec.edu/kb/article/pdf-forms-inserting-an-automatic-date-field/

* Convert PDF to Base64 online : https://base64.guru/converter/encode/pdf
