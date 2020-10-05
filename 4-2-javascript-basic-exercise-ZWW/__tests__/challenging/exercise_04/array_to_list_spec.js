import arrayToList from '../../../src/exercise_04/arrayToList';

// Please do NOT modifiy the code in this file.
describe('for array to list', () => {
  it('should throw if array is not defined or empty', () => {
    expect(() => arrayToList()).toThrowError('Creating list from undefined array');
    expect(() => arrayToList(null)).toThrowError('Creating list from undefined array');
    expect(() => arrayToList([])).toThrowError('Creating list from empty array');
  });

  it('should create list for one element array', () => {
    const list = arrayToList([1]);
    expect(list.next).toBeNull();
    expect(list.value).toEqual(1);
  });

  it('should create list for two element array', () => {
    const list = arrayToList([1, 2]);
    expect(list.value).toEqual(1);
    expect(list.next).toEqual({ value: 2, next: null });
  });

  it('should create list for three element array', () => {
    const list = arrayToList([1, 2, 3]);
    expect(list.value).toEqual(1);
    expect(list.next.value).toEqual(2);
    expect(list.next.next).toEqual({ value: 3, next: null });
  });
});
