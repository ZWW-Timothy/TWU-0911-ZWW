export default function flattenArray(array) {
  // This function flattens a nested array into a sequence.
  //
  // Your target:
  //
  // * Please implement this function and pass all the tests in flatten_array_spec.js.
  // * Please do NOT modify the signature of the function.

  const farr = [];

  if (array === null || array === undefined) {
    throw new Error('Flatten undefined or null array');
  }

  for (let i = 0; i < array.length; i += 1) {
    if (Array.isArray(array[i])) {
      for (let j = 0; j < array[i].length; j += 1) {
        farr.push(array[i][j]);
      }
    } else {
      farr.push(array[i]);
    }
  }

  return farr;
}
