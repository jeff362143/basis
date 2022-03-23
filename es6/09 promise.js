/**
Promise的诞生就是为了更好管理使用异步
1、Promise实例可传入一个函数,函数参数resolve和reject也是函数,用于表示该promise实例的状态是成功还是失败。
new Promise((resolve, reject) => {
    if(true) {
         resolve('success')
    }else {
        reject('fail')
    }
});
因为promise是管理异步操作的,resolve,reject函数分别会在我们自定义的异步操作成功执行和失败执行后调用
2、Promise实例的then方法参数为两个函数,分别对应resolve和reject；根据promise实例中的异步函数调用的是resolve还是reject，来决定执行then方法两个参数中其中一个函数。利用then的话我们就可以执行多次回调了。
注:promise实例的then方法返回值也是promise实例

*/





*/
	let p = new Promise((resolve, reject) => {
		// 执行异步操作
		setTimeout(() => {
		 	// 执行成功
			resolve('成功执行');

			// 执行失败
			// reject('执行失败');
		}, 3000)// 
	});	
	
	// 监听结果
	p
	.then(res => {
		console.log('success', 111, res)
		return res;
	}, err => console.log('error', 111, err))
	.then(res => console.log('success', 222, res), err => console.log('error', err))
	.then(res => console.log('success', res), err => console.log('error', err))
	.then(res => console.log('success', res), err => console.log('error', err))
