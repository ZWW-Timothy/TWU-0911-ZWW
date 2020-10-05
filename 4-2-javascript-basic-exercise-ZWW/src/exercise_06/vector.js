export default class Vector {
  // This class represents a 2-dimensional vector. Please implement the class according to the
  // following instructions:
  //
  // * We should be able to get the `x` part and `y` part of a vector.
  // * We should be able to calculate the plus and minus of 2 vectors.
  // * We should be able to calculate the distance of a vector.
  //
  // Your target:
  //
  // * Please implement the class and pass all the tests in vector_spec.js.
  // * Please do NOT modify the signature of the class. Please put all your code in the Vector
  // class.

  constructor(x, y) {
    this._x = x;
    this._y = y;
  }

  get x() {
    return this._x;
  }

  get y() {
    return this._y;
  }

  // eslint-disable-next-line class-methods-use-this
  set x(x) {
    // eslint-disable-next-line no-throw-literal
    throw '';
  }

  // eslint-disable-next-line class-methods-use-this
  set y(y) {
    // eslint-disable-next-line no-throw-literal
    throw '';
  }

  static plus(v1, v2) {
    const vp = {
      x: v1.x + v2.x,
      y: v1.y + v2.y,
    };
    return vp;
  }

  static minus(v1, v2) {
    const vm = {
      x: v1.x - v2.x,
      y: v1.y - v2.y,
    };
    return vm;
  }

  distance() {
    const d = Math.sqrt(this._x * this._x + this._y * this._y);
    return d;
  }
}
