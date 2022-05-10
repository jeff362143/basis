import axios from 'axios'

export default function ajax(url,data={},type='get'){
     return new Promise(function(resolve,reject){
     let promise;
     if(type === 'get'){
          let dataStr = '';
          Object.keys(data).forEach(
               index => {
                    dataStr += index + "=" + data[index] + "&";
               })
          if(dataStr != ''){
               dataStr = dataStr.substring(0,dataStr.lastIndexOf('&'));
               url = url + '?' + dataStr;    
          }
          promise = axios.get(url);      //   axios.get(url)就是一个Promise()实例
     }else{
          let json = JSON.stringify(data);
          promise = axios.post(url,`json=${json}`);
          // promise = axios.post(url,json);
     }
     promise.then(function(response){
          resolve(response)        //    resolve和reject对应Promise()的返回值，这个resolve对应的是上面的new Promise
     }).catch(function(error){
          reject(error);
     })
     });
}