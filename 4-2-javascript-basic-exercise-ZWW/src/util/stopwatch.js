export default class Stopwatch {
  constructor() {
    this.startTime = new Date();
  }

  get elapsedMs() {
    return new Date() - this.startTime;
  }
}
