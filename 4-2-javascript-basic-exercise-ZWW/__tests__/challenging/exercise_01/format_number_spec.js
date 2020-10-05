import formatNumber from '../../../src/exercise_01/numberFormatter';

// Please do NOT modifiy the code in this file.
describe('We would like to format number', () => {
  it('should format number with dollar sign if currency option is specified', () => {
    const formatted = formatNumber(2, { currency: true });

    expect(formatted).toEqual('$ 2.00');
  });

  it('should round number to 2 numerics', () => {
    const formatted = formatNumber(2.718);

    expect(formatted).toEqual('2.72');
  });

  it('should combine number rounding and dollar sign', () => {
    const formatted = formatNumber(2.718, { currency: true });

    expect(formatted).toEqual('$ 2.72');
  });
});
