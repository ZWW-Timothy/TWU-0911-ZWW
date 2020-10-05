export default function arrayToList(array) {
  // This function creates a linked list from an array.
  //
  // Your target:
  //
  // * Please implement this function and pass all the tests in array_to_list_spec.js.
  // * Please do NOT modify the signature of the function.

  if (array === null || array === undefined) {
    throw new Error('Creating list from undefined array');
  }

  if (array.length === 0) {
    throw new Error('Creating list from empty array');
  }

  const list = {
    value: array[0],
    next: null,
  };

  let temp = list;

  for (let i = 1; i < array.length; i += 1) {
    const position = {
      value: array[i],
      next: null,
    };
    temp.next = position;
    temp = position;
  }

  return list;
}
