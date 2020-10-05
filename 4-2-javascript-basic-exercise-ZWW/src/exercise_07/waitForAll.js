export default function waitForAll(...promises) {
  // This function returns a promise which will be triggered when all the `promises` are completed.
  //
  // If all the `promises` are resolved, then the returned promise will be resolved. Otherwise,
  // if one of the `promises` is rejected, then the returned promise will be rejected.
  //
  // Your target:
  //
  // * Please implement this function and pass all the tests in wait_for_all_spec.js.
  // * Please do NOT modify the signature of the function.

  for (let i = 0; i < promises.length; i += 1) {
    if (typeof (promises[i].then) !== 'function') {
      throw new Error('Not all elements are promises.');
    }
  }

  return new Promise((resolve, reject) => {
    const pl = promises.length;
    let nrej = 0;
    for (let i = 0; i < pl; i += 1) {
      promises[i]
        .then(() => {
          if (i + 1 === pl) {
            if (nrej) {
              reject();
            }
            resolve();
          }
        })
        .catch(() => {
          nrej += 1;
        });
    }
  });
}
