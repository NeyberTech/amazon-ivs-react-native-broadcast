package com.amazonivsreactnativebroadcast.IVSBroadcastCameraView;

import java.util.*;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

import javax.annotation.Nullable;

public class IVSBroadcastCameraViewManger extends ViewGroupManager<IVSBroadcastCameraView> {
  @Override
  public String getName() {
    return "RCTIVSBroadcastCameraView";
  }

  @Override
  public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
    MapBuilder.Builder<String, Object> builder = MapBuilder.<String, Object>builder();
    for (IVSBroadcastCameraView.Events event : IVSBroadcastCameraView.Events.values()) {
      builder.put(event.toString(), MapBuilder.of("registrationName", event.toString()));
    }
    return builder.build();
  }

  @Nullable
  @Override
  public Map<String, Integer> getCommandsMap() {
    return MapBuilder.of(IVSBroadcastCameraView.START_COMMAND_NAME, 0,
      IVSBroadcastCameraView.STOP_COMMAND_NAME, 1,
      IVSBroadcastCameraView.SWAP_CAMERA_COMMAND_NAME, 2);
  }

  @Override
  public void receiveCommand(IVSBroadcastCameraView view, String commandId, @Nullable ReadableArray args) {
    switch (commandId) {
      case IVSBroadcastCameraView.START_COMMAND_NAME: {
        view.start();
        break;
      }
      case IVSBroadcastCameraView.STOP_COMMAND_NAME: {
        view.stop();
        break;
      }
      case IVSBroadcastCameraView.SWAP_CAMERA_COMMAND_NAME: {
        view.swapCamera();
        break;
      }
      default: {
        throw new RuntimeException("The following command is not supported yet: " + commandId);
      }
    }
  }

  @Override
  protected IVSBroadcastCameraView createViewInstance(ThemedReactContext reactContext) {
    return new IVSBroadcastCameraView(reactContext);
  }

  @Override
  public void onDropViewInstance(IVSBroadcastCameraView view) {
    super.onDropViewInstance(view);
    view.cleanUp();
  }

  @ReactProp(name = "isCameraPreviewMirrored")
  public void setIsCameraPreviewMirrored(IVSBroadcastCameraView view, boolean isCameraPreviewMirrored) {
    view.setIsCameraPreviewMirrored(isCameraPreviewMirrored);
  }

  @ReactProp(name = "cameraPosition")
  public void setCameraPosition(IVSBroadcastCameraView view, String cameraPosition) {
    view.setCameraPosition(cameraPosition);
  }

  @ReactProp(name = "cameraPreviewAspectMode")
  public void setCameraPreviewAspectMode(IVSBroadcastCameraView view, String cameraPreviewAspectMode) {
    view.setCameraPreviewAspectMode(cameraPreviewAspectMode);
  }

  @ReactProp(name = "rtmpsUrl")
  public void setRtmpsUrl(IVSBroadcastCameraView view, String rtmpsUrl) {
    view.setRtmpsUrl(rtmpsUrl);
  }

  @ReactProp(name = "streamKey")
  public void setStreamKey(IVSBroadcastCameraView view, String streamKey) {
    view.setStreamKey(streamKey);
  }

  @ReactProp(name = "logLevel")
  public void setLogLevel(IVSBroadcastCameraView view, String logLevel) {
    view.setLogLevel(logLevel);
  }

  @ReactProp(name = "sessionLogLevel")
  public void setSessionLogLevel(IVSBroadcastCameraView view, String sessionLogLevel) {
    view.setSessionLogLevel(sessionLogLevel);
  }

  @ReactProp(name = "videoConfig")
  public void setVideoConfig(IVSBroadcastCameraView view, ReadableMap videoConfig) {
    view.setVideoConfig(videoConfig);
  }

  @ReactProp(name = "audioConfig")
  public void setAudioConfig(IVSBroadcastCameraView view, ReadableMap audioConfig) {
    view.setAudioConfig(audioConfig);
  }
}
