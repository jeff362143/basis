        // 定icktPromise
	let IcktPromise = function(callback) {
		// 定义状态
		this.status = 'pending';
		// 定义操作成功执行完毕之后的队列
		this.resolvedArr = [];
		// 定义操作失败执行完毕之后的队列
		this.rejectedArr = [];
		// 定义resolve方法
		let resolve = (value) => {
			// 缓存value
			this.doneValue = value;
			// 改变状态
			this.status = 'resolved';
			// 执行操作成功执行完毕之后的队列
			this.resolvedArr.forEach(fn => value = fn(value));
		}
		// 定义reject方法
		let reject = (value) => {
			// 缓存value
			this.doneValue = value;
			// 改变状态
			this.status = 'rejected';
			// 执行操作失败执行完毕之后的队列
			this.rejectedArr.forEach(fn => value = fn(value));
		}
		
		try {
			callback(resolve, reject);
		} catch (e) {
			reject(e);
		}
	}

	// 添加then方法
	IcktPromise.prototype.then = function(success, fail) {
		// 判断状态
		if (this.status === 'pending') {
			// 使用&& 优化
			typeof success === 'function' && this.resolvedArr.push(success); 
			typeof fail === 'function' && this.rejectedArr.push(fail); 
		} else if (this.status === 'resolved') {
			// 立即执行
			typeof success === 'function' && success(this.doneValue);
		} else {
			typeof fail === 'function' && fail(this.doneValue);
		}
		// 链式调用
		return this;
	}


	// 测试
	let p = new IcktPromise((resolve, reject) => {
		// 执行异步操作
		setTimeout(() => {
		// 	// 执行成功
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