import { range, sum } from '../../../src/exercise_03/rangeAndSum';

// Please do NOT modifiy the code in this file.
describe('for range and sum', () => {
  it('should create array within range', () => {
    expect(range(0, 0)).toEqual([]);
    expect(range(1, 1)).toEqual([]);
    expect(range(0, 5)).toEqual([0, 1, 2, 3, 4]);
    expect(range(3, 4)).toEqual([3]);
    expect(range(3, 5)).toEqual([3, 4]);
    expect(range(3, -2)).toEqual([3, 2, 1, 0, -1]);
    expect(range(-2, -5)).toEqual([-2, -3, -4]);
  });

  it('should sum all the numbers', () => {
    expect(sum()).toEqual(0);
    expect(sum(0)).toEqual(0);
    expect(sum(1)).toEqual(1);
    expect(sum(1, 2, 3)).toEqual(6);
    expect(sum(...[1, 2, 3])).toEqual(6);
    expect(sum(-1, -5, 1)).toEqual(-5);
  });

  it('should be combined together', () => {
    expect(sum(...range(1, 11))).toEqual(55);
  });
});
