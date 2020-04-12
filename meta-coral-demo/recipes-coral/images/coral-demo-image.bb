# This image extends fsl-image-multimedia-full with Coral example applications

require recipes-fsl/images/fsl-image-multimedia-full.bb

CORE_IMAGE_EXTRA_INSTALL += " \
    edgetpu-demo \
    python3-edgetpu \
    python3-edgetpu-examples \
    python3-edgetpuvision \
"
