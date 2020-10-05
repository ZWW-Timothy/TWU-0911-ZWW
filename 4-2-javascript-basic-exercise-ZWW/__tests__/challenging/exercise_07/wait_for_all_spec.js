import waitForAll from '../../../src/exercise_07/waitForAll';
import Stopwatch from '../../../src/util/stopwatch';

// Please do NOT modifiy the code in this file.
describe('for wait for all', () => {
  function createDelayedPromise(delayInMs, success = true) {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        if (success) { resolve(); } else { reject(); }
      }, delayInMs);
    });
  }

  it('should throw if not all elements are promises', () => {
    const notAllElementsArePromises = [Promise.resolve(), 2];
    expect(() => waitForAll(...notAllElementsArePromises)).toThrowError('Not all elements are promises.');
  });

  it('should wait for all promises to resolve to get a resolved promise', (done) => {
    const stopwatch = new Stopwatch();
    const delay50ms = createDelayedPromise(50);
    const delay1000ms = createDelayedPromise(1000);
    waitForAll(delay50ms, delay1000ms)
      .then(() => {
        expect(stopwatch.elapsedMs).toBeGreaterThanOrEqual(1000);
        done();
      });
  });

  it('should wait for all promise for reject scenario', (done) => {
    const stopwatch = new Stopwatch();
    const delay50msFailed = createDelayedPromise(50, false);
    const delay1000msSuccess = createDelayedPromise(1000);
    waitForAll(delay50msFailed, delay1000msSuccess)
      .then(
        // eslint-disable-next-line no-undef
        () => fail('It should not be a success promise'),
        () => {
          expect(stopwatch.elapsedMs).toBeGreaterThanOrEqual(1000);
          done();
        },
      );
  });
});
